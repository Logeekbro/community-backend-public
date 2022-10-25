package com.db.community;

import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@SpringBootTest
public class TestLinkedList {

    @Test
    public void test1() {
        List<String> list = new LinkedList<>(Arrays.asList("1", "2", "3"));
        list.add("4");
        System.out.println(list);
        list.remove(0);
        System.out.println(list);
    }
}
