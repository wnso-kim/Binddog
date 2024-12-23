package org.binddog.binddoghub.flow.document;

import lombok.*;
import org.binddog.binddoghub.global.entity.BaseDocument;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

@Getter
@Builder
@ToString
@Document(collection = "flow")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Flow extends BaseDocument {
    
    @Id
    private String flowId;
    private String title;
    private String description;
    private Long projectId;
    private List<Block> blocks;
    private List<Link> links;

    @Getter
    @Builder
    @ToString
    @AllArgsConstructor
    public static class Position {
        private Float x;
        private Float y;
    }


    @Getter
    @Builder
    @ToString
    @AllArgsConstructor
    public static class Block {
        private Long blockId;
        private String method;
        private String endpoint;
        private String name;
        private Position position;
        private Map<String, String> header;
        private Map<String, String> parameter;
        private Map<String, String> pathVariable;
        private Map<String, Object> request;
        private Map<String, Object> response;
        private Map<String, String> pathValue;
        private Map<String, String> paramValue;
        private Map<String, String> headerValue;
    }

    @Getter
    @Builder
    @ToString
    @AllArgsConstructor
    public static class Link {
        private Long linkId;
        private Long fromBlockId;
        private Long toBlockId;
        private List<Mapping> mappings;
    }

    @Getter
    @Builder
    @ToString
    @AllArgsConstructor
    public static class Mapping {
        private String fromFieldType;
        private String fromField;
        private String toFieldType;
        private String toField;
    }
}