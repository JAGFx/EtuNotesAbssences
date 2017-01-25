package projet.Component;

import java.util.LinkedHashMap;

/**
 * Created by SMITHE on 25-Jan-17.
 */
public class QueryBuilder {
	private String query;
	private LinkedHashMap< String, Object > params;
	
	public QueryBuilder( String query ) {
		this.query = query;
		params = new LinkedHashMap<>();
	}
	
	public QueryBuilder( String query, LinkedHashMap< String, Object > params ) {
		this.query = query;
		this.params = params;
	}
	
	public String getQuery() {
		return query;
	}
	
	public void setQuery( String query ) {
		this.query = query;
	}
	
	public LinkedHashMap< String, Object > getParams() {
		return params;
	}
	
	public void setParams( LinkedHashMap< String, Object > params ) {
		this.params = params;
	}
	
	public void addParam( String key, Object value ) {
		params.put( key, value );
	}
}
