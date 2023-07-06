/*
 * Copyright 2013-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.dbemp.demos.web;

import org.springframework.web.bind.annotation.*;

import java.util.List;

//DispatcherServlet
@RestController//接口
@RequestMapping("/emp")
public class EmpController {

    private EmpMapper EmpMapper = new EmpMapper();

    /**
     * 分页查询
     * @param page
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/list")
    public List<Emp> list(int page, int pageSize) {
        return EmpMapper.list(page, pageSize);
    }

    /**
     * 新增
     * @param e
     */
    @RequestMapping("/save")
    public void save(Emp e) {
        EmpMapper.addEmp(e);
    }

    /**
     * 删除
     * @param id
     */
    @RequestMapping("/{id}")
    public void delete(@PathVariable int id) {
        EmpMapper.deleteEmp(id);
    }

}
