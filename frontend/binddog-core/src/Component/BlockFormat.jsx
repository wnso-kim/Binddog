import React from "react";
import { Card, Typography, Box } from "@mui/material";
import { useTheme } from "@mui/material/styles";
import { Handle, Position } from "@xyflow/react";

// ReactFlow 안에 생기는 블록 커스텀 포맷
export default function BlockFormat({ data }) {
  const theme = useTheme();

  // JSON 데이터에서 전달받은 추가적인 속성을 구조 분해 할당
  const {
    method,
    apiName,
    endpoint,
    header,
    parameter,
    pathVariable,
    response,
  } = data;

  return (
    <Card
      sx={{
        bgcolor: theme.palette.block[method],
        borderRadius: "8px",
        width: "220px",
        padding: "8px 8px 2px",
        cursor: "grab",
        boxShadow: "-4px 4px 2px rgba(0, 0, 0, 0.4)",
      }}
    >
      <Handle type="target" position={Position.Left} />
      <Box
        sx={{
          display: "flex",
          alignItems: "center",
          justifyContent: "space-between",
          gap: 1,
        }}
      >
        <Typography sx={theme.method}>{method}</Typography>

        <Box
          sx={{
            display: "flex",
            flexDirection: "column",
            alignItems: "flex-start",
            flexGrow: 1,
          }}
        >
          <Box
            sx={{
              bgcolor: "white",
              padding: "8px 2px",
              borderRadius: "4px",
              width: "175px",
              mb: "2px",
              display: "flex",
              justifyContent: "center",
              wordBreak: "keep-all",
              overflowWrap: "break-word",
            }}
          >
            <Typography sx={theme.api}>{apiName}</Typography>
          </Box>
          <Typography sx={{ ...theme.endpoint, padding: "5px" }}>
            {endpoint}
          </Typography>
        </Box>
      </Box>

      {/* 추가 속성 렌더링 */}
      <Box>
        {header && (
          <Typography sx={theme.api}>
            Header: {JSON.stringify(header)}
          </Typography>
        )}
        {parameter && (
          <Typography sx={theme.api}>
            Parameter: {JSON.stringify(parameter)}
          </Typography>
        )}
        {pathVariable && (
          <Typography sx={theme.api}>
            Path Variable: {JSON.stringify(pathVariable)}
          </Typography>
        )}
        {response && (
          <Typography sx={theme.api}>
            Response: {JSON.stringify(response)}
          </Typography>
        )}
      </Box>

      <Handle type="source" position={Position.Right} id="a" />
    </Card>
  );
}
