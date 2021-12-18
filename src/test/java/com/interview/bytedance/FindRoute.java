package com.interview.bytedance;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给出一个二维数组表示的迷宫，判断是否可以从起点到达终点
 * "s" 表示起点，"e"表示终点，"#"表示障碍物，"."表示畅通
 *
 */
public class FindRoute {

    static class Point {
        int x;
        int y;

        Point(int p1, int p2) {
            x = p1;
            y = p2;
        }
    }

    @Test
    public void test() {
        String allChar =
                "s...##.\n" +
                ".#.....\n" +
                ".......\n" +
                "..#....\n" +
                "..#...#\n" +
                "###...#\n" +
                "......e";
        char[][] room = getRoomByAllChar(allChar);
        boolean b = judjeRoute(room);
        System.out.println(b);
    }

    public char[][] getRoomByAllChar(String allChar) {
        String[] strings = allChar.split("\n");
        List<String> req = Arrays.asList(strings);
        return getRoomByLineList(req);
    }

    public char[][] getRoomByLineList(List<String> req) {
        char[][] room = new char[req.size()][];
        for (int i = 0; i < req.size(); i++) {
            room[i] = req.get(i).toCharArray();
        }
        return room;
    }


    public boolean judjeRoute(char[][] room) {
        List<Point> currRoute = new ArrayList<>();
        currRoute.add(new Point(0, 0));

        return judjeRoute(room, currRoute);

    }

    public void printRoute(char[][] room, List<Point> currRoute) {
        char[][] tmpRoom = new char[room.length][];
        for (int i = 0; i < room.length; i++) {
            tmpRoom[i] = new char[room[i].length];
            for (int j = 0; j < room[i].length; j++) {
                for (Point point : currRoute) {
                    if(point.x == i && point.y == j){
                        tmpRoom[i][j] = '*';
                    }else if( tmpRoom[i][j] == '\u0000'){
                        tmpRoom[i][j] = room[i][j];
                    }
                }
            }
        }

        for (int i = 0; i < room.length; i++) {
            System.out.println();
            for (int j = 0; j < room[i].length; j++) {
                System.out.print(tmpRoom[i][j]);
            }
        }
        System.out.println("\n-------------");

    }

    public boolean judjeRoute(char[][] room, List<Point> currRoute) {
        printRoute(room,currRoute);
        for (int i = 1; i <= 4; i++) {
            Point nextPoint = tryNearByPoint(room, currRoute, i);
            if (nextPoint != null) {
                if (room[nextPoint.x][nextPoint.y] == 'e') {
                    return true;
                }
                currRoute.add(nextPoint);
                boolean result = judjeRoute(room, currRoute);
                if (result) {
                    return true;
                } else {
                    currRoute.remove(nextPoint);
                }
            }
        }
        return false;
    }


    public Point tryNearByPoint(char[][] room, List<Point> currRoute, Integer fx) {
        Point currPoint = currRoute.get(currRoute.size() - 1);

        int nx = currPoint.x;
        int ny = currPoint.y;
        if (fx == 1) {
            nx = currPoint.x + 1;
            if (nx == room.length) {
                return null;
            }
        } else if (fx == 2) {
            ny = currPoint.y + 1;
            if (ny == room[nx].length) {
                return null;
            }
        } else if (fx == 3) {
            nx = currPoint.x - 1;
            if (nx == -1) {
                return null;
            }
        } else if (fx == 4) {
            ny = currPoint.y - 1;
            if (ny == -1) {
                return null;
            }
        }
        for (Point prevPoint : currRoute) {
            if (prevPoint.x == nx && prevPoint.y == ny) {
                return null;
            }
            if (room[nx][ny] == '#') {
                return null;
            }

        }
        return new Point(nx, ny);
    }

    // 一个确定的寻路顺序：  向右，向下，向左，向上
    // 记录当前的路径
    // 深度优先
}
