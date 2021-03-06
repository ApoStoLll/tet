package com.ms.tet.parts

class Part_X (point: Point, cor: Int):Part(){

    var pointD: Point;

    init{
        this.pivo = point;
        this.pointA = Point(this.pivo.x-1, this.pivo.y);
        this.pointB = Point(this.pivo.x+1, this.pivo.y);
        this.pointC = Point(this.pivo.x, this.pivo.y+1);
        this.pointD = Point(this.pivo.x, this.pivo.y-1);

        this.cor = cor;
    }

    override fun pecaMoveDown(board: Array<Array<Int>>): Boolean{
        if(valida_MD(board)){
            this.pivo.moveDown();
            this.pointA.moveDown();
            this.pointB.moveDown();
            this.pointC.moveDown();
            this.pointD.moveDown();
            return true;
        }else{
            return false;
        }
    }

    override fun pecaMoveLeft(board: Array<Array<Int>>){
        if(valida_ML(board)){
            this.pivo.moveLeft();
            this.pointA.moveLeft();
            this.pointB.moveLeft();
            this.pointC.moveLeft();
            this.pointD.moveLeft();
        }
    }

    override fun pecaMoveRight(board: Array<Array<Int>>){
        if(valida_MR(board)){
            this.pivo.moveRight();
            this.pointA.moveRight();
            this.pointB.moveRight();
            this.pointC.moveRight();
            this.pointD.moveRight();
        }
    }

    //Peca não possui giro, visto que seu visual não muda
    override fun pecaFlip(board: Array<Array<Int>>){}

    override fun getPosition(): ArrayList<Array<Int>>{
        var positionPivo = arrayOf<Int>(this.pivo.x, this.pivo.y);
        var positionA = arrayOf<Int>(this.pointA.x, this.pointA.y);
        var positionB = arrayOf<Int>(this.pointB.x, this.pointB.y);
        var positionC = arrayOf<Int>(this.pointC.x, this.pointC.y);
        var positionD = arrayOf<Int>(this.pointD.x, this.pointD.y);

        var positionPeca: ArrayList<Array<Int>> = ArrayList();
        positionPeca.add(positionPivo);
        positionPeca.add(positionA);
        positionPeca.add(positionB);
        positionPeca.add(positionC);
        positionPeca.add(positionD);

        return positionPeca;
    }

    fun valida_MD(board: Array<Array<Int>>):Boolean {
        if( board[this.pointB.x+1][this.pointB.y] != 1 ||
            board[this.pointC.x+1][this.pointC.y] != 1 ||
            board[this.pointD.x+1][this.pointD.y] != 1){
            return true;
        }else{
            return false
        }
    }

    fun valida_ML(board: Array<Array<Int>>):Boolean {
        if(board[this.pointD.x][this.pointD.y-1] != 1){
            return true;
        }else{
            return false
        }
    }

    fun valida_MR(board: Array<Array<Int>>):Boolean {
        if(board[this.pointC.x][this.pointC.y+1] != 1){
            return true;
        }else{
            return false
        }
    }
}