package com.example.demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumArrayTest {
    SumArray sumArray = new SumArray();

    @Test
    void testSumValid() {
        int mang[] = {2, 3, 4};
        int ketQua = sumArray.tinhTongMang(mang);
        assertEquals(9, ketQua);
    }

    @Test
    void testSumSoAm() {
        int mang[] = {-2, -3, -4};
        int ketQua = sumArray.tinhTongMang(mang);
        assertEquals(-9, ketQua);
    }

    @Test
    void testSumMangRong() {
        int mang[] = {};
        int ketQua = sumArray.tinhTongMang(mang);
        assertEquals(0, ketQua);
    }

    @Test
    void testSumNull() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            int mang[] = null;
            sumArray.tinhTongMang(mang);
        });
        assertEquals("mang khong duoc nullll", exception.getMessage());
    }

    @Test
    void tinhTong3() {

    }


    @Test
    void tongMangSoNguyenBoQua100() {
        Integer mang =  sumArray.tongMangSoNguyenBoQua100(new int[] {1,3,102});
        assertEquals(4, mang);
    }

    @Test
    void tinhTong2() {
        assertEquals(482,sumArray.tinhTong2());
    }
}