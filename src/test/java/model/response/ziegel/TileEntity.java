package model.response.ziegel;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum TileEntity {
    // General Tile Entities
    LOCAL_TILE,
    REMOTE_TILE,

    // Music Tile Entities
    SONG,
    ALBUM,
    COLLECTION,
    PAGE,
    LANGUAGE,
    ARTIST,

    // Xstream Tile Entities
    MOVIE,
    PAGEREF,
    SHORTMOVIE,
    VIDEO,
    TVSHOW,
    SEASON,
    EPISODE,
    CATCHUP,
    SPORTS,
    PROGRAM,
    LIVETVCHANNEL,
    LIVE,
    NEWS,
    APPS,
    HUAWEI,
    LIVETVMOVIE,
    LIVETVSHOW,
    UNKNOWN,
    PROMO,
    OTHER,
    ADS_TILE,
    TRAILER,
    CONTENT; // match tile entity

    private static Map<String, TileEntity> stringTileEntityMap;

    static {
        stringTileEntityMap =
                Arrays.stream(TileEntity.values())
                        .collect(Collectors.toMap(f -> f.name().toLowerCase(), f -> f));
    }

    public static TileEntity getTileEntityFromString(String input) {
        return stringTileEntityMap.getOrDefault(input.toLowerCase(), UNKNOWN);
    }
}
