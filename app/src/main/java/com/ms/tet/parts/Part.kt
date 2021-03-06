package com.ms.tet.parts

abstract class Part() {
    var cor:Int? = null;
    lateinit var pivo:Point;
    lateinit var pointA:Point;
    lateinit var pointB:Point;
    lateinit var pointC:Point;

    abstract fun pecaMoveDown(board: Array<Array<Int>>): Boolean;
    abstract fun pecaMoveLeft(board: Array<Array<Int>>);
    abstract fun pecaMoveRight(board: Array<Array<Int>>);
    abstract fun pecaFlip(board: Array<Array<Int>>);
    abstract fun getPosition(): ArrayList<Array<Int>>;
}