package com.db.community.utils;

import com.db.community.model.vo.SingleKeyVO;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicBoolean;

@Slf4j
public class SingleKeyVOFactory {

    // 初始容量最好为 2^n
    private static int POOL_COUNT = 32;
    private static final Queue<SingleKeyVO> POOL = new ArrayBlockingQueue<>(POOL_COUNT);


    private static void addVO(int size) {
        for (int i = 0; i < size; i++) {
            POOL.add(new SingleKeyVO());
        }
    }

    public static void init() {
        log.warn("SingleKeyVO Pool Start Init...");
        addVO(POOL_COUNT);
        log.info("SingleKeyVO Pool Init Success !");
    }

    public static SingleKeyVO getSingleKeyVO() {
        SingleKeyVO vo = POOL.poll();
        if (vo != null) {
            return vo;
        }
        // 容量不足时进行双倍扩容
        else {
            log.warn("SingleKeyVO Pool is empty, Starting add size...");
            POOL_COUNT *= 2;
            addVO(POOL_COUNT);
            log.info("Add complete !");
            return POOL.poll();
        }
    }

    public static void recycleVO(SingleKeyVO vo) {
        CompletableFuture.runAsync(() -> POOL.add(vo));
    }


}
