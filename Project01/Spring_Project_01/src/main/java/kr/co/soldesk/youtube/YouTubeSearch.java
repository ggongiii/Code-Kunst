package kr.co.soldesk.youtube;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.SearchListResponse;
import com.google.api.services.youtube.model.SearchResult;

import kr.co.soldesk.beans.YouTubeDto;

@Component
public class YouTubeSearch {

    private static final String APPLICATION_NAME = "youtubeAPI";
    private static final String API_KEY = "AIzaSyAr8N23My6GyAuxpnbBBoUcrayxfPbxma8";

    public List<YouTubeDto> searchVideos(String query) {
        List<YouTubeDto> videos = new ArrayList<>();
        try {
            YouTube youtubeService = new YouTube.Builder(GoogleNetHttpTransport.newTrustedTransport(), JacksonFactory.getDefaultInstance(), null)
                    .setApplicationName(APPLICATION_NAME)
                    .build();

            YouTube.Search.List request = youtubeService.search().list("snippet");
            SearchListResponse response = request.setKey(API_KEY)
                    .setQ(query)
                    .setMaxResults(20L) // 20개의결과를 가져옴
                    .execute();

            for (SearchResult result : response.getItems()) {
                YouTubeDto video = new YouTubeDto();
                video.setVideoId(result.getId().getVideoId());
                video.setTitle(result.getSnippet().getTitle());
                video.setThumbnailUrl(result.getSnippet().getThumbnails().getDefault().getUrl());
                video.setHighThumbnailUrl(result.getSnippet().getThumbnails().getHigh().getUrl()); // 고화질 썸네일
                videos.add(video);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return videos;
    }

    public List<YouTubeDto> getRandomVideos(List<YouTubeDto> videos, int count) {
        Collections.shuffle(videos);
        return videos.subList(0, Math.min(count, videos.size()));
    }
}
