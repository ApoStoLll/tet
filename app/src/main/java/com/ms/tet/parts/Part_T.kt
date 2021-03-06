package com.ms.tet.parts

class Part_T(point: Point, cor: Int):Part(){

    var flip:Array<Int>;
    var contFlip:Int;

    init{
        this.pivo = point;
        this.pointA = Point(this.pivo.x+1, this.pivo.y);
        this.pointB = Point(this.pivo.x, this.pivo.y-1);
        this.pointC = Point(this.pivo.x, this.pivo.y+1);
        this.cor = cor;
        this.flip =  arrayOf<Int>(0, 1, 2, 3);
        this.contFlip = 0;
    }

    override fun pecaMoveDown(board: Array<Array<Int>>): Boolean{
        if(valida_MD(board)){
            this.pivo.moveDown();
            this.pointA.moveDown();
            this.pointB.moveDown();
            this.pointC.moveDown();
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
        }
    }

    override fun pecaMoveRight(board: Array<Array<Int>>){
        if(valida_MR(board)){
            this.pivo.moveRight();
            this.pointA.moveRight();
            this.pointB.moveRight();
            this.pointC.moveRight();
        }
    }

    override fun pecaFlip(board: Array<Array<Int>>){
        if(valida_Flip(board)){
            when {
                this.flip[this.contFlip] == 0 -> {
                    this.pointC.moveUp();
                    this.pointC.moveLeft();

                    this.contFlip++;
                }
                this.flip[this.contFlip] == 1 -> {
                    this.pointA.moveUp();
                    this.pointA.moveRight();
                    this.contFlip++;
                }
                this.flip[this.contFlip] == 2 -> {
                    this.pointB.moveRight();
                    this.pointB.moveDown();
                    this.contFlip++;
                }
                this.flip[this.contFlip] == 3 -> {
                    this.pointA.moveDown();
                    this.pointA.moveLeft();

                    this.pointB.moveLeft();
                    this.pointB.moveUp();

                    this.pointC.moveDown();
                    this.pointC.moveRight();

                    this.contFlip = 0;
                }
            }
        }
    }

    override fun getPosition(): ArrayList<Array<Int>>{
        var positionA = arrayOf<Int>(this.pointA.x, this.pointA.y);
        var positionB = arrayOf<Int>(this.pointB.x, this.pointB.y);
        var positionC = arrayOf<Int>(this.pointC.x, this.pointC.y);
        var positionPivo = arrayOf<Int>(this.pivo.x, this.pivo.y);

        var positionPeca: ArrayList<Array<Int>> = ArrayList();
        positionPeca.add(positionPivo);
        positionPeca.add(positionA);
        positionPeca.add(positionB);
        positionPeca.add(positionC);

        return positionPeca;
    }

    fun valida_MD(board: Array<Array<Int>>):Boolean {
        if( board[this.pivo.x+1][this.pivo.y] != 1 &&
            board[this.pointA.x+1][this.pointA.y] != 1 &&
            board[this.pointB.x+1][this.pointB.y] != 1 &&
            board[this.pointC.x+1][this.pointC.y] != 1){
            return true;
        }else{
            return false
        }
    }

    fun valida_ML(board: Array<Array<Int>>):Boolean {
        if( board[this.pivo.x][this.pivo.y-1] != 1 &&
                board[this.pointA.x][this.pointA.y-1] != 1 &&
                board[this.pointB.x][this.pointB.y-1] != 1 &&
                board[this.pointC.x][this.pointC.y-1] != 1){
            return true;
        }else{
            return false
        }
    }

    fun valida_MR(board: Array<Array<Int>>):Boolean {
        if( board[this.pivo.x][this.pivo.y+1] != 1 &&
                board[this.pointA.x][this.pointA.y+1] != 1 &&
                board[this.pointB.x][this.pointB.y+1] != 1 &&
                board[this.pointC.x][this.pointC.y+1] != 1){
            return true;
        }else{
            return false
        }
    }

    fun valida_Flip(board: Array<Array<Int>>):Boolean{
        if( board[this.pointA.x+1][this.pointA.y-1] != 1 ||
                board[this.pointB.x+2][this.pointB.y-2] != 1 ||
                board[this.pointC.x+3][this.pointC.y-3] != 1 ){
            return true;
        }else{
            return false;
            }
    }
}