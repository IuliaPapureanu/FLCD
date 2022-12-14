from domain.grammar import Grammar
from domain.parser import Parser
from domain.tree import Tree


class UI:

    def __init__(self):
        self.grammar = None
        self.parser = None

    def run(self):
        while True:
            print(">>")
            cmd = input()
            if cmd == "g1":
                self.evaluateG1()
            elif cmd == "g2":
                self.evaluateG2()

    def readG1(self):
        self.g1 = Grammar.fromFile('g1.txt')
        print('Read g1')

    def readG2(self):
        self.g2 = Grammar.fromFile('g2.txt')
        print('Read g2')

    def readSequence(self, fname):
        sequence = ""
        with open(fname, 'r') as fin:
            for line in fin.readlines():
                sequence += line.strip() + " "
        return sequence.strip()

    def evaluateG1(self):
        self.readG1()
        self.p1 = Parser(self.g1)
        print("FIRST SET")
        print(self.p1.firstSet)
        print("FOLLOW SET")
        print(self.p1.followSet)
        print("PARSING TABLE")
        for k in self.p1.table.keys():
            print(k, '->', self.p1.table[k])

        print("SEQUENCE EVALUATION")
        result = self.p1.evaluateSequence(self.readSequence('seq.txt'))
        if result is None:
            print("Sequence not accepted")
        else:
            print(result)
            t = Tree(self.g1)
            print("BUILDING TREE")
            t.build(result.strip().split(' '))
            print("TREE")
            t.print_table()

    def evaluateG2(self):
        self.readG2()
        self.p2 = Parser(self.g2)
        print("FIRST SET")
        print(self.p2.firstSet)
        print("FOLLOW SET")
        print(self.p2.followSet)
        print("PARSING TABLE")
        for k in self.p2.table.keys():
            print(k, '->', self.p2.table[k])

        print("SEQUENCE EVALUATION")
        result = self.p2.evaluateSequence(self.readSequence('pif.txt'))
        if result is None:
            print("Sequence not accepted")
        else:
            print(result)
            t = Tree(self.g2)
            print("BUILDING TREE")
            t.build(result.strip().split(' '))
            print("TREE")
            t.print_table()
