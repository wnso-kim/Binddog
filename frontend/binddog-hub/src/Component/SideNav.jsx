import { Box, Typography } from "@mui/material";
import React from "react";
import { useTheme } from "@mui/material/styles";
import { Link } from "react-router-dom";

function SideNav({ li, title }) {
  const theme = useTheme();

  return (
    <Box
      sx={{
        width: "250px",
        bgcolor: "#F7F7F7",
        display: "flex",
        flexDirection: "column",
        padding: "50px",
        alignItems: "flex-start",
        gap: 3,
      }}
    >
      <Typography component="div" sx={theme.typography.h3}>
        유저의 허브
      </Typography>
      <Box
        sx={{
          color: theme.palette.text.secondary,
          fontSize: theme.fontSize.large,
          display: "flex",
          flexDirection: "column",
          gap: 2,
        }}
      >
        {li.map((item, index) => (
          <Typography component="li" key={index} sx={theme.typography}>
            {item.title}
          </Typography>
        ))}
      </Box>
    </Box>
  );
}

export default SideNav;
