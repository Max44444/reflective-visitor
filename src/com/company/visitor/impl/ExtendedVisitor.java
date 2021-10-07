package com.company.visitor.impl;

import com.company.nodes.AANode;
import com.company.nodes.BNode;
import com.company.nodes.CNode;
import com.company.visitor.annotation.VisitPoint;

public class ExtendedVisitor extends DefaultNodeVisitor {

    @VisitPoint(forClass = CNode.class)
    private void visitNodeC(CNode node) {
        System.out.println("CCCCCCCCCCCCCCC: " + node.getNodeInfo());
    }

    @VisitPoint(forClass = AANode.class)
    private void visitNodeAA(AANode node) {
        System.out.println("2A2A2A2A2A2A2A2: " + node.getNodeInfo());
    }

    @Override
    protected void visitNodeB(BNode node) {
        System.out.println("222222222222222: " + node.getNodeInfo());
    }
}
