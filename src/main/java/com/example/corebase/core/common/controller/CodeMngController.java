package com.example.corebase.core.common.controller;

import com.example.corebase.core.base.model.ResponseObject;
import com.example.corebase.core.common.service.CodeMngService;
import com.example.corebase.core.common.service.dto.CodeMngDTO;
import com.example.corebase.core.common.service.dto.CodeMngResListDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/code")
public class CodeMngController {

    private final Logger log = LoggerFactory.getLogger(CodeMngController.class);

    private final CodeMngService codeMngService;

    public CodeMngController(CodeMngService codeMngService) {
        this.codeMngService = codeMngService;
    }

    @GetMapping("/search")
    public ResponseObject getCodeByUpId(@RequestParam String upCdId) {
        try {
            return new ResponseObject(codeMngService.getByUpId(upCdId));
        } catch (Exception e) {
            log.error(e.getMessage());
            throw e;
        }
    }

    @PostMapping("/listCode")
    public ResponseObject<List<CodeMngDTO>> getCodeByUpIdList(@RequestBody CodeMngResListDTO codeMngResDTO) {
        List<CodeMngDTO> codeMngDTOS = codeMngService.getListCode(codeMngResDTO.getUpCdIdList());
        return new ResponseObject(codeMngDTOS);
    }
}
