package com.kata.bowling;

import junit.framework.TestCase;

/**
 * @author: chenyutao
 * @date: 2021/9/23 7:10 下午
 */
public class TestMain extends TestCase {
    public void testAllZero(){
        ScoreCalService game = new ScoreCalService();
        for (int i = 0; i < 20; i++) {
            game.roll(0);
        }
        assertEquals(0,game.score());
    }

    public void testAllOne(){
        ScoreCalService game = new ScoreCalService();
        for (int i = 0; i < 20; i++) {
            game.roll(1);
        }
        assertEquals(20,game.score());
    }

    private ScoreCalService game;

    @Override
    protected void setUp() throws Exception {
        game = new ScoreCalService();
    }

    private void rollMany(int n,int pins){
        for (int i = 0; i < n; i++) {
            game.roll(pins);
        }
    }

    public void testAllZero2(){
        rollMany(20,0);
        assertEquals(0,game.score());
    }

    public void testAllOne2(){
        rollMany(20,1);
        assertEquals(20,game.score());
    }

    public void testOneSpare(){
        game.roll(7);
        game.roll(3);
        game.roll(2);
        rollMany(17,0);
        assertEquals(14,game.score());
    }

    public void testOneStrike(){
        game.roll(10);
        game.roll(2);
        game.roll(3);
        rollMany(17,0);
        assertEquals(20,game.score());
    }

    public void testAllSpare(){
        rollMany(20,5);
        game.roll(5); // last spare need roll extra one
        assertEquals(150,game.score());
    }

    public void testAllStrike(){
        rollMany(10,10);
        game.roll(10);// last strike need roll extra two
        game.roll(10);
        assertEquals(300,game.score());
    }


    public void testOther1(){
        roll(1);
        roll(9);
        roll(5);
        roll(4);
        roll(6);
        roll(4);
        roll(10);
        roll(0);
        roll(10);
        roll(0);
        roll(0);
        roll(0);
        roll(0);
        System.out.println(game.score());
//        assertEquals(64,game.score());
    }

    private void roll(int pins){
        game.roll(pins);
    }


}
