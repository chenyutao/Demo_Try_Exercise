package com.kata.bowling;

/**
 * @author: chenyutao
 * @date: 2021/9/23 7:10 下午
 */
public class ScoreCalService {

    public ScoreCalService() {
    }

    private final int[] score = new int[21];
    private int index = 0;

    public void roll(int n){
        if(index>=score.length){
            return;
        }
        score[index] = n;
        index++;
    }

    public int score(){
        int totalScoreVal = 0;
        int rollIndex = 0;
        for (int frameIndex = 0; frameIndex < 10; frameIndex++) {
            if(hitStrike(rollIndex)){
                totalScoreVal+=this.calFrameScoreForStrike(rollIndex);
                rollIndex+=1;
            }else if(hitSpare(rollIndex)){
                totalScoreVal+=this.calFrameScoreForSpare(rollIndex);
                rollIndex+=2;
            }else {
                totalScoreVal+=this.calFrameScoreForNormal(rollIndex);
                rollIndex+=2;
            }
        }
        return totalScoreVal;
    }

    private boolean hitSpare(int i){
        return score[i]!=10 && score[i]+score[i+1]==10;
    }

    private boolean hitStrike(int i){
        return score[i]==10;
    }

    private int calFrameScoreForNormal(int rollIndex){
        if(hitStrike(rollIndex)|| hitSpare(rollIndex)){
            throw new RuntimeException("compute score logic error");
        }
        return score[rollIndex]+score[rollIndex+1];
    }

    private int calFrameScoreForSpare(int rollIndex){
        if(!hitSpare(rollIndex)){
            throw new RuntimeException("compute score logic error");
        }
        return 10+score[rollIndex+2];
    }

    private int calFrameScoreForStrike(int rollIndex){
        if(!hitStrike(rollIndex)){
            throw new RuntimeException("compute score logic error");
        }
        return 10+score[rollIndex+1]+score[rollIndex+2];
    }




}
