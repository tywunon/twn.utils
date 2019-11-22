package twn.ui.fx.context;

import java.util.HashMap;
import java.util.Map;

import javafx.scene.Node;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.ContextMenuEvent;
import twn.lang.Tuple.*;

public final class ContextManager {
	
	private static Map<Node, Tuple3<ContextMenu, Map<String, MenuItem>, Map<String, Menu>>> menuMap = new HashMap<>();
	
	private static Tuple3<ContextMenu, Map<String, MenuItem>, Map<String, Menu>> getNodeMenu(Node node){
		if(!menuMap.containsKey(node))
			menuMap.put(node, Tuple3.Create(new ContextMenu(), new HashMap<>(), new HashMap<>()));
		return menuMap.get(node);
	}
	
	private static ContextMenu getContextMenuForNode(Node node)
	{	
		return getNodeMenu(node).item1;
	}
	
	private static MenuItem getMenuItemForNode(Node node, String identifier){
		if(!getNodeMenu(node).item2.containsKey(identifier)) {
			getNodeMenu(node).item2.put(identifier, new MenuItem());
		}
		return getNodeMenu(node).item2.get(identifier);
	}
	
	private static Menu getParentMenuForNode(Node node, String identifier){
		if(!getNodeMenu(node).item3.containsKey(identifier)) {
			Menu menu = new Menu();
			menu.setText(identifier);
			getNodeMenu(node).item3.put(identifier, menu);
		}
		return getNodeMenu(node).item3.get(identifier);
	}
	
	public static void AddContextParentMenu(Node node, String identifier, String caption) {
		ContextMenu contextMenu = getContextMenuForNode(node);
		node.setOnContextMenuRequested((event) -> onContextMenuRequested(node, contextMenu, event));
		Menu menu = getParentMenuForNode(node, identifier);
		menu.setText(caption);
		contextMenu.getItems().remove(menu);
		contextMenu.getItems().add(menu);
	}
	
	public static void AddContextMenu(Node node, String identifier, String caption, IContextMenuCommand command, IContextMenuCanCommand  canCommand){
		AddContextMenu(node, null, identifier, caption, command, canCommand);
	}
	
	public static void AddContextMenu(Node node, String parentIdentifier, String itemIdentifier, String itemCaption, IContextMenuCommand command, IContextMenuCanCommand  canCommand){
		ContextMenu contextMenu = getContextMenuForNode(node);
		node.setOnContextMenuRequested((event) -> onContextMenuRequested(node, contextMenu, event));
		MenuItem menuItem = getMenuItemForNode(node, itemIdentifier);
		menuItem.setText(itemCaption);
		menuItem.setOnAction((event) -> {if(!canCommand.check()) return; command.execute();});				
		contextMenu.getItems().remove(menuItem);
		if(parentIdentifier != null)
		{
			Menu menu = getParentMenuForNode(node, parentIdentifier);
			contextMenu.getItems().remove(menu);
			menu.getItems().add(menuItem);
			contextMenu.getItems().add(menu);
		}else
		{
			contextMenu.getItems().add(menuItem);
		}
	}
	
	private static void onContextMenuRequested(Node node, ContextMenu contextMenu, ContextMenuEvent event){
		contextMenu.show(node, event.getScreenX(), event.getScreenY());
	}
}
