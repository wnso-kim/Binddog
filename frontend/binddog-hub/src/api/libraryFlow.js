// 라이브러리 - 플로우

import Axios from "./index";

// 특정 프로젝트의 플로우 조회
export const getAllFlow = async (projectId) => {
  try {
    const response = await Axios.get(`projects/${projectId}/flows`);
    return response.data.data.flows;
  } catch (error) {
    console.error("Error fetching flows:", error);
    throw error;
  }
};

// 특정 프로젝트의 플로우 삭제
export const deleteFlow = async (projectId, flowId) => {
  const response = await Axios.delete(`projects/${projectId}/flows/${flowId}`, {
    params: { projectId, flowId },
  });
  return response.data;
};

// 플로우 이미지 불러오기
export const loadImage = async (projectId, flowId) => {
  const response = await Axios(`images/${projectId}/${flowId}`, {
    baseURL: process.env.REACT_APP_API_URL,
  });
  return response.data;
};
