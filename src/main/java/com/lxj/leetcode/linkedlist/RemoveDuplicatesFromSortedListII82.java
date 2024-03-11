package com.lxj.leetcode.linkedlist;

import java.util.*;

/**
 * @author Xingjing.Li
 * @since 2/2/2024
 */
public class RemoveDuplicatesFromSortedListII82 {
	public ListNode deleteDuplicates(ListNode head) {
		Map<Integer, List<ListNode>> nodeHashMap = new LinkedHashMap<>();
		ListNode listNode = new ListNode();
		ListNode retNode = listNode;
		while (head != null){
			List<ListNode> listNodes = nodeHashMap.getOrDefault(head.val, new ArrayList<>());
			listNodes.add(head);
			nodeHashMap.put(head.val, listNodes);
			head = head.next;
		}
		if (!nodeHashMap.isEmpty()){
			for (Map.Entry<Integer, List<ListNode>> entry : nodeHashMap.entrySet()) {
				List<ListNode> value = entry.getValue();
				if(value.size() == 1){
					listNode.next = new ListNode(value.get(0).val);
					listNode = listNode.next;
				}
			}
		}
		return retNode.next;
	}


	public static void main(String[] args) {
		RemoveDuplicatesFromSortedListII82 solution = new RemoveDuplicatesFromSortedListII82();
		ListNode listNode = new ListNode(1,
				new ListNode(2,
						new ListNode(3,
								new ListNode(3,
										new ListNode(4,
												new ListNode(4,
														new ListNode(5)))))));
		solution.deleteDuplicates(listNode);
	}
}
