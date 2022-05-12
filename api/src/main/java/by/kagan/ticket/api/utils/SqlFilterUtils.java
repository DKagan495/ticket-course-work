package by.kagan.ticket.api.utils;

import by.kagan.ticket.api.annotation.AnotherName;
import by.kagan.ticket.api.annotation.AnotherTable;
import by.kagan.ticket.api.filter.ApiFilter;
import org.springframework.data.util.Pair;

import java.lang.reflect.Field;
import java.util.*;

import static by.kagan.ticket.api.utils.NamingUtils.*;

public class SqlFilterUtils {
	
	private final LinkedHashSet<String> joinClauses = new LinkedHashSet<>();
	private final LinkedHashSet<String> selectClauses = new LinkedHashSet<>();
	private final LinkedHashSet<String> orderByClauses = new LinkedHashSet<>();
	
	/**
	 * Completes a filter`s query.
	 * Filter`s query includes WHERE-clauses,
	 * JOIN-clauses,
	 * SELECT-clauses,
	 * ORDER BY-clauses
	 */
	public static <T extends ApiFilter> String getQuery(T filter) {
	
	}
	
	/**
	 * Method result is completed WHERE-statement of SQL-query result
	 */
	private static <T extends ApiFilter> Pair<LinkedHashSet<String>, LinkedHashSet<String>> completeWhereClauses(T filter) {
		LinkedHashSet<String> whereClauses = new LinkedHashSet<>();
		LinkedHashSet<String> joinClauses = new LinkedHashSet<>();
		
		Field[] filterFields = filter.getClass().getDeclaredFields();
		
		Map<String, Object> filterFieldMap = new HashMap<>();
		
		Arrays.stream(filterFields).forEach(field -> {
			field.setAccessible(true);
			try {
				filterFieldMap.put(field.getName(), field.get(filter));
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		});
		
		filterFieldMap.keySet().forEach(key -> {
			Optional.ofNullable(filterFieldMap.get(key)).ifPresent(value ->
			{
				try {
					var anotherNameAnnotation = getAnotherNameAnnotation(filter.getClass(), key);
					var anotherTableAnnotation = getAnotherTableAnnotation(filter.getClass(), key);
					
					anotherTableAnnotation.ifPresentOrElse(anotherTable -> anotherNameAnnotation.ifPresent(
									anotherName -> {
										joinClauses.add("left join " + anotherTable.value() + " on \"" + anotherTable + "\".id = " + anotherTable.homeTableCol());
										
										whereClauses.add(value instanceof Collection
												                 ? "%s in %s".formatted(anotherName.value(), value.toString().replace('[', '(').replace(']', ')'))
												                 : "%s = %s".formatted(anotherName.value(), value));
									}),
							() -> anotherNameAnnotation.ifPresentOrElse(
									anotherName -> whereClauses.add(value instanceof Collection
											                                ? "%s in %s".formatted(anotherName.value(), value.toString().replace('[', '(').replace(']', ')'))
											                                : "%s = %s".formatted(anotherName.value(), value)),
									() -> whereClauses.add(value instanceof Collection
											                       ? "%s in (%s)".formatted(fromCamelToSnakeCase(key), value.toString().replace('[', '(').replace(']', ')'))
											                       : "%s = %s".formatted(fromCamelToSnakeCase(key), value))));
					
				} catch (NoSuchFieldException e) {
					e.printStackTrace();
				}
			});
		});
		
		return Pair.of(joinClauses, whereClauses);
	}
	
	/**
	 * Method result is completed ORDER BY statement with a pagination(limit offset) of SQL-query result
	 */
	private static LinkedHashSet<String> completeSelectAndOrderByClauses(Set<String> orderByClauses, Set<String> joinClauses) {
	
	}
	
	private static <E> Optional<AnotherName> getAnotherNameAnnotation(Class<E> clazz, String fieldName) throws NoSuchFieldException {
		return Optional.ofNullable(clazz.getDeclaredField(fieldName)
				.getDeclaredAnnotation(AnotherName.class));
	}
	
	private static <E> Optional<AnotherTable> getAnotherTableAnnotation(Class<E> clazz, String fieldName) throws NoSuchFieldException {
		return Optional.ofNullable(clazz.getDeclaredField(fieldName)
				.getDeclaredAnnotation(AnotherTable.class));
	}
}
