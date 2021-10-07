package com.company.visitor.impl;

import com.company.nodes.ANode;
import com.company.nodes.BNode;
import com.company.visitor.Visitor;
import com.company.visitor.annotation.VisitPoint;

public class DefaultNodeVisitor extends Visitor {

    @VisitPoint(forClass = ANode.class)
    protected void visitNodeA(ANode node) {
        System.out.println("AAAAAAAAAAAAAAA: " + node.getNodeInfo());
    }

    @VisitPoint(forClass = BNode.class)
    protected void visitNodeB(BNode node) {
        System.out.println("BBBBBBBBBBBBBBB: " + node.getNodeInfo());
    }

}
