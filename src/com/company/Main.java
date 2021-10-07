package com.company;

import com.company.nodes.AANode;
import com.company.nodes.ANode;
import com.company.nodes.BNode;
import com.company.nodes.CNode;
import com.company.visitor.impl.DefaultNodeVisitor;
import com.company.visitor.impl.ExtendedVisitor;
import com.company.visitor.exception.UnsupportedNodeForVisitException;

public class Main {

    public static void main(String[] args) throws UnsupportedNodeForVisitException {
        final var aNode = new ANode();
        final var bNode = new BNode();
        final var cNode = new CNode();
        final var aaNode = new AANode();

        final var extendedVisitor = new ExtendedVisitor();
        extendedVisitor.visitNode(aNode);
        extendedVisitor.visitNode(bNode);
        extendedVisitor.visitNode(cNode);
        extendedVisitor.visitNode(aaNode);

        final var defaultNodeVisitor = new DefaultNodeVisitor();
        defaultNodeVisitor.visitNode(aNode);
        defaultNodeVisitor.visitNode(bNode);

        try {
            defaultNodeVisitor.visitNode(cNode);
        } catch (UnsupportedNodeForVisitException e) {
            System.out.println("Operation for cNode not found");
        }

        try {
            defaultNodeVisitor.visitNode(aaNode);
        } catch (UnsupportedNodeForVisitException e) {
            System.out.println("Operation for aaNode not found");
        }
    }
}
