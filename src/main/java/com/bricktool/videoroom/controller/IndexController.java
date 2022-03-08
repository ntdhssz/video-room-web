package com.bricktool.videoroom.controller;

import com.bricktool.videoroom.dto.IndexDTO;
import com.bricktool.videoroom.service.IndexService;
import com.bricktool.videoroom.util.RestResult.ResultData;
import com.bricktool.videoroom.util.RestResult.ResultUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/index")
public class IndexController {
    private final IndexService indexService;

    public IndexController(IndexService indexService) {
        this.indexService = indexService;
    }

    @GetMapping
    public ResultData index(@RequestParam(value = "type", defaultValue = "0") int type,
                            @RequestParam(value = "keyword", required = false) String keyword,
                            @RequestParam(value = "page", defaultValue = "1") int page,
                            @RequestParam(value = "page_size", defaultValue = "20") int pageSize) {
        IndexDTO indexDTO = new IndexDTO(type, keyword, page, pageSize);
        return ResultUtil.success(indexService.index(indexDTO));
    }
}
