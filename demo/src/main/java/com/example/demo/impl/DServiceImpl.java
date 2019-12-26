package com.example.demo.impl;

import com.example.demo.DService;

/**
 * @author: DHJ
 * @create: 2019/12/20 10:06
 * Description:
 */
public class DServiceImpl implements DService {

    private final com.example.demo.impl.DDelegate DDelegate = new DDelegate();

    @Override
    public void a() {

        DDelegate.a();
    }

    @Override
    public void b() {

    }
}
