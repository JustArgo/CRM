package com.pakin.crm.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pakin.crm.domain.Node;

public class TreeUtil {

	public static List<Node> getTree(List<Map> departments) {
		List<Node> root = new ArrayList<Node>();
		Node tempNode = null;
		Map<String, Node> bigMap = new HashMap<String, Node>();
		for (int i = 0; i < departments.size(); i++) {
			String id = String.valueOf(departments.get(i).get("id"));
			String text = String.valueOf(departments.get(i).get("text"));
			tempNode = new Node(id, text);
			bigMap.put(id, tempNode);
		}
		for (int i = 0; i < departments.size(); i++) {
			if (departments.get(i).get("pid") == null) {
				root.add(bigMap.get(String
						.valueOf(departments.get(i).get("id"))));
			} else {
				Node parentNode = bigMap.get(String.valueOf(departments.get(i)
						.get("pid")));
				Node node = bigMap.get(String.valueOf(departments.get(i).get(
						"id")));
				parentNode.getChildren().add(node);
			}
		}
		return root;
	}

}
