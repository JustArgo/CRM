package com.pakin.crm.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
@Component
@Getter
@Setter
public class Node {
	private String id;
	private String text;
	private List<Node> children=new ArrayList<>();
	public Node(String id, String text, List<Node> children) {
		super();
		this.id = id;
		this.text = text;
		this.children = children;
	}
	public Node(String id, String text) {
		super();
		this.id = id;
		this.text = text;
	}
	public Node() {
		super();
	}
	
}
