package org.binddog.binddoghub.flow.repository;

import org.binddog.binddoghub.flow.document.Flow;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface FlowRepository extends MongoRepository<Flow, String> {

    void deleteByProjectIdAndFlowId(Long projectId, String flowId);

    List<Flow> findAllByProjectId(Long projectId);
}
