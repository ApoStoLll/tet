package com.ms.tet.parts

class Point (var x: Int, var y: Int) {
    fun moveUp(){
        x--;
    }

    fun moveDown() {
        x++;
    }

    fun moveLeft() {
        y--;
    }

    fun moveRight() {
        y++;
    }
}