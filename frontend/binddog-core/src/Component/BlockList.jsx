import React from "react";
import { Box, Typography } from "@mui/material";
import { useTheme } from "@mui/material/styles";
import Block from "./Block";
import blocksData from "../block.json";

function BlockList({ li = blocksData.blocks, name, addNode }) {
  const theme = useTheme();

  return (
    <Box
      sx={{
        width: "250px",
        height: "100%",
        bgcolor: "#F7F7F7",
        display: "flex",
        flexDirection: "column",
        padding: "50px",
        alignItems: "flex-start",
        gap: 3,
      }}
    >
      <Typography
        sx={{
          ...theme.typography.h3,
          marginBottom: "20px",
        }}
      >
        {name}
      </Typography>
      {li.map((item) => (
        <Block
          key={item.blockId}
          id={item.blockId}
          method={item.method}
          apiName={item.name}
          endpoint={item.endpoint}
          position={item.position}
          header={item.header}
          parameter={item.parameter}
          pathVariable={item.pathVariable}
          request={item.request}
          response={item.response}
          addNode={addNode}
        />
      ))}
    </Box>
  );
}

export default BlockList;
