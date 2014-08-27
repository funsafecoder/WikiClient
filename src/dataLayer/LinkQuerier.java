package dataLayer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.neo4j.graphalgo.PathFinder;
import org.neo4j.graphdb.Direction;
import org.neo4j.graphdb.DynamicLabel;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Path;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.ResourceIterable;
import org.neo4j.rest.graphdb.RestGraphDatabase;
import org.neo4j.rest.graphdb.query.RestCypherQueryEngine;

public class LinkQuerier {
	
	private RestGraphDatabase graphDB;
	private RestCypherQueryEngine engine;
	
	public LinkQuerier(){
		graphDB = new RestGraphDatabase("http://localhost:7474/db/data");
		engine = new RestCypherQueryEngine(graphDB.getRestAPI());
	}
	
	public LinkQuerier(String connectionString){
		graphDB = new RestGraphDatabase(connectionString);
		engine = new RestCypherQueryEngine(graphDB.getRestAPI());
	}
	
	public ArrayList<String> getLinksOnPage(String pageTitle){
		Set<String> pagesLinkedTo = new HashSet<String>();
		
		Label label = DynamicLabel.label( "Page" );
		ResourceIterable<Node> pageReturned = graphDB.findNodesByLabelAndProperty(label, "title", pageTitle);
		
		for (Node page : pageReturned){
			for (Relationship relationship : page.getRelationships(Direction.OUTGOING)){
				String title = (String)relationship.getEndNode().getProperty("title");
				pagesLinkedTo.add(title);
			}
		}
		
		return new ArrayList<String>(pagesLinkedTo);
	}
	
	public ArrayList<String> getLinksToPage(String pageTitle){
		Set<String> pagesLinkedFrom = new HashSet<String>();
		
		Label label = DynamicLabel.label( "Page" );
		ResourceIterable<Node> pageReturned = graphDB.findNodesByLabelAndProperty(label, "title", pageTitle);
		
		for (Node page : pageReturned){
			for (Relationship relationship : page.getRelationships(Direction.INCOMING)){
				String title = (String)relationship.getStartNode().getProperty("title");
				pagesLinkedFrom.add(title);
			}
		}
		
		return new ArrayList<String>(pagesLinkedFrom);
	}
	
	public int getNumberOfLinksOnPage(String pageTitle){
		int NumOfLinks = 0;
		
		Label label = DynamicLabel.label( "Page" );
		ResourceIterable<Node> pageReturned = graphDB.findNodesByLabelAndProperty(label, "title", pageTitle);
		
		for (Node page : pageReturned){
			for (Relationship relationship : page.getRelationships(Direction.OUTGOING)){
				NumOfLinks++; // Grand total not node specific
			}
		}
		
		return NumOfLinks;
	}
	
	public int getNumberOfLinksToPage(String pageTitle){
		int NumOfLinks = 0;
		
		Label label = DynamicLabel.label( "Page" );
		ResourceIterable<Node> pageReturned = graphDB.findNodesByLabelAndProperty(label, "title", pageTitle);
		
		for (Node page : pageReturned){
			for (Relationship relationship : page.getRelationships(Direction.INCOMING)){
				NumOfLinks++; // Grand total not node specific
			}
		}
		
		return NumOfLinks;
	}
	
//	public void getShortestPath(String startTitle, String destinationTitle){
//		
//	}
}
