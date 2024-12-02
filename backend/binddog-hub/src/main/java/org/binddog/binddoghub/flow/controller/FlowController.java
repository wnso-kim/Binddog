package org.binddog.binddoghub.flow.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.binddog.binddoghub.flow.dto.req.FlowCreateReq;
import org.binddog.binddoghub.flow.dto.req.FlowRegisterReq;
import org.binddog.binddoghub.flow.dto.res.FlowCreateRes;
import org.binddog.binddoghub.flow.dto.res.FlowSearchRes;
import org.binddog.binddoghub.flow.dto.res.FlowsSearchRes;
import org.binddog.binddoghub.flow.service.FlowService;
import org.binddog.binddoghub.global.enums.NoneResponse;
import org.binddog.binddoghub.global.response.Response;
import org.binddog.binddoghub.global.response.SuccessResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/projects")
public class FlowController {

    private final FlowService flowService;

    @Operation(
            summary = "Load all flow",
            description = "load all of saved flows."
    )
    @GetMapping("/{projectId}/flows")
    public ResponseEntity<Response<FlowsSearchRes>> getFlows(
            @AuthenticationPrincipal Long memberId,
            @PathVariable Long projectId
    ) {
        SuccessResponse<FlowsSearchRes> response
                = flowService.loadFlows(memberId, projectId);
        return Response.success(response);
    }

    @Operation(
            summary = "Load flow",
            description = "Load a saved flow."
    )
    @GetMapping("/{projectId}/flows/{flowId}")
    public ResponseEntity<Response<FlowSearchRes>> getFlow(
            @AuthenticationPrincipal Long memberId,
            @PathVariable Long projectId,
            @PathVariable String flowId
    ) {
        SuccessResponse<FlowSearchRes> response
                = flowService.loadFlow(memberId, projectId, flowId);
        return Response.success(response);
    }

    @Operation(
            summary = "Create flow",
            description = "Create a new flow."
    )
    @PostMapping("/{projectId}/flows")
    public ResponseEntity<Response<FlowCreateRes>> createFlow(
            @PathVariable Long projectId,
            @RequestBody FlowCreateReq flowCreateReq,
            @AuthenticationPrincipal Long memberId
    ) {
        log.info(flowCreateReq.toString());
        SuccessResponse<FlowCreateRes> response
                = flowService.createFlow(memberId, projectId, flowCreateReq);
        log.info("Create Flow Success : [{}]", projectId);
        return Response.success(response);
    }

    @Operation(
            summary = "Overwrite flow",
            description = "Overwrites any modifications made to the existing flow."
    )
    @PutMapping("/{projectId}/flows/{flowId}")
    public ResponseEntity<Response<NoneResponse>> overWriteFlow(
            @PathVariable Long projectId,
            @PathVariable String flowId,
            @RequestBody FlowRegisterReq flowRegisterReq,
            @AuthenticationPrincipal Long memberId
    ) {
        log.info(flowRegisterReq.toString());
        SuccessResponse<NoneResponse> response
                = flowService.saveFlow(memberId, projectId, flowId, flowRegisterReq);
        log.info("OverWrite Flow Success : [{}]", projectId);
        return Response.success(response);
    }

    @Operation(
            summary = "Delete flow",
            description = "Delete the flow."
    )
    @DeleteMapping("/{projectId}/flows/{flowId}")
    public ResponseEntity<Response<NoneResponse>> deleteFlow(
            @PathVariable Long projectId,
            @PathVariable String flowId,
            @AuthenticationPrincipal Long memberId
    ) {
        log.info("FlowController.deleteFlow (memberId : {})", memberId);
        log.info("FlowController.deleteFlow (projectId : {})", projectId);
        log.info("FlowController.deleteFlow (flowId : {})", flowId);
        SuccessResponse<NoneResponse> response
                = flowService.deleteFlow(memberId, projectId, flowId);
        return Response.success(response);
    }


}
