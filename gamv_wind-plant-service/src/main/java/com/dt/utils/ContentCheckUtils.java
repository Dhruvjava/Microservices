package com.dt.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

@Slf4j
public class ContentCheckUtils implements Serializable {
    //
    //    private static final long serialVersionUID = -1592761675509799288L;
    //
    //    private static List<String> IMAGE_CONTENT_TYPES = new ArrayList<String>(
    //                    Arrays.asList("image/gif", "image/png", "image/jpeg", "image/bmp", "image/webp",
    //                                    "image/vnd.microsoft.icon", "image/jpg"));
    //
    //    private static List<String> PDF_CONTENT_TYPES =
    //                    new ArrayList<String>(Arrays.asList("application/pdf"));
    //
    //    private static List<String> TEXT_CONTENT_TYPES = new ArrayList<String>(
    //                    Arrays.asList("text/plain", "text/html", "text/css", "text/javascript"));
    //
    //    private static List<String> DOC_CONTENT_TYPES = new ArrayList<String>(Arrays.asList(
    //                    "application/msword",
    //                    "application/vnd.openxmlformats-officedocument.wordprocessingml.document",
    //                    "application/vnd.openxmlformats-officedocument.wordprocessingml.template"));
    //
    //    private static List<String> PPT_CONTENT_TYPES = new ArrayList<String>(Arrays.asList(
    //                    "application/vnd.ms-powerpoint",
    //                    "application/vnd.openxmlformats-officedocument.presentationml.presentation",
    //                    "application/vnd.openxmlformats-officedocument.presentationml.template",
    //                    "application/vnd.openxmlformats-officedocument.presentationml.slideshow"));
    //
    //    private static List<String> EXCEL_CONTENT_TYPES = new ArrayList<String>(Arrays.asList(
    //                    "application/vnd.ms-excel",
    //                    "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet",
    //                    "application/vnd.openxmlformats-officedocument.spreadsheetml.template"));
    //
    //    private static List<String> AUDIO_CONTENT_TYPES = new ArrayList<String>(
    //                    Arrays.asList("audio/basic", "audio/mid", "audio/mpeg", "audio/mp3",
    //                                    "audio/mp4", "audio/x-aiff", "audio/ogg", "audio/vnd.wav"));
    //
    //    private static List<String> VIDEO_CONTENT_TYPES =
    //                    new ArrayList<String>(Arrays.asList("video/mpeg", "video/mp4", "video/ogg",
    //                                    "video/webm", "video/x-ms-wmv", "video/x-msvideo"));
    //
    //    private static List<String> ARCHIVE_CONTENT_TYPES = new ArrayList<String>(Arrays.asList(
    //                    "application/zip", "application/x-rar-compressed", "application/x-gtar",
    //                    "application/vnd.android.package-archive", "application/x-7z-compressed"));
    //
    //    public static boolean isImage(String contentType) {
    //
    //        if (log.isDebugEnabled()) {
    //            log.debug("Executing isImage(contentType) ->");
    //        }
    //
    //        try {
    //            if (Utils.isEmpty(contentType)) {
    //                log.error("contenttype IS EMPTY--->");
    //                return false;
    //            }
    //            if (IMAGE_CONTENT_TYPES.contains(contentType)) {
    //                return true;
    //            }
    //            return false;
    //        } catch (Exception e) {
    //            log.error("Exception in isImage(contentType) ->" + e);
    //            return false;
    //        }
    //    }
    //
    //    public static boolean isPdf(String contentType) {
    //
    //        if (log.isDebugEnabled()) {
    //            log.debug("Executing isPdf(contentType) ->");
    //        }
    //
    //        try {
    //            if (Utils.isEmpty(contentType)) {
    //                log.error("contenttype IS EMPTY--->");
    //                return false;
    //            }
    //            if (PDF_CONTENT_TYPES.contains(contentType)) {
    //                return true;
    //            }
    //            return false;
    //        } catch (Exception e) {
    //            log.error("Exception in isPdf(contentType) ->" + e);
    //            return false;
    //        }
    //    }
    //
    //    public static boolean isText(String contentType) {
    //
    //        if (log.isDebugEnabled()) {
    //            log.debug("Executing isText(contentType) ->");
    //        }
    //
    //        try {
    //            if (Utils.isEmpty(contentType)) {
    //                log.error("contenttype IS EMPTY--->");
    //                return false;
    //            }
    //            if (TEXT_CONTENT_TYPES.contains(contentType)) {
    //                return true;
    //            }
    //            return false;
    //        } catch (Exception e) {
    //            log.error("Exception in isText(contentType) ->" + e);
    //            return false;
    //        }
    //    }
    //
    //    public static boolean isDocument(String contentType) {
    //
    //        if (log.isDebugEnabled()) {
    //            log.debug("Executing isDocument(contentType) ->");
    //        }
    //
    //        try {
    //            if (Utils.isEmpty(contentType)) {
    //                log.error("contenttype IS EMPTY--->");
    //                return false;
    //            }
    //            if (DOC_CONTENT_TYPES.contains(contentType)) {
    //                return true;
    //            }
    //            return false;
    //        } catch (Exception e) {
    //            log.error("Exception in isDocument(contentType) ->" + e);
    //            return false;
    //        }
    //    }
    //
    //    public static boolean isPresentation(String contentType) {
    //
    //        if (log.isDebugEnabled()) {
    //            log.debug("Executing isPresentation(contentType) ->");
    //        }
    //
    //        try {
    //            if (Utils.isEmpty(contentType)) {
    //                log.error("contenttype IS EMPTY--->");
    //                return false;
    //            }
    //            if (PPT_CONTENT_TYPES.contains(contentType)) {
    //                return true;
    //            }
    //            return false;
    //        } catch (Exception e) {
    //            log.error("Exception in isPresentation(contentType) ->" + e);
    //            return false;
    //        }
    //    }
    //
    //    public static boolean isSpreadsheet(String contentType) {
    //
    //        if (log.isDebugEnabled()) {
    //            log.debug("Executing isSpreadsheet(contentType) ->");
    //        }
    //
    //        try {
    //            if (Utils.isEmpty(contentType)) {
    //                log.error("contenttype IS EMPTY--->");
    //                return false;
    //            }
    //            if (EXCEL_CONTENT_TYPES.contains(contentType)) {
    //                return true;
    //            }
    //            return false;
    //        } catch (Exception e) {
    //            log.error("Exception in isSpreadsheet(contentType) ->" + e);
    //            return false;
    //        }
    //    }
    //
    //    public static boolean isAudio(String contentType) {
    //
    //        if (log.isDebugEnabled()) {
    //            log.debug("Executing isAudio(contentType) ->");
    //        }
    //
    //        try {
    //            if (Utils.isEmpty(contentType)) {
    //                log.error("contenttype IS EMPTY--->");
    //                return false;
    //            }
    //            if (AUDIO_CONTENT_TYPES.contains(contentType)) {
    //                return true;
    //            }
    //            return false;
    //        } catch (Exception e) {
    //            log.error("Exception in isAudio(contentType) ->" + e);
    //            return false;
    //        }
    //    }
    //
    //    public static boolean isVideo(String contentType) {
    //
    //        if (log.isDebugEnabled()) {
    //            log.debug("Executing isVideo(contentType) ->");
    //        }
    //
    //        try {
    //            if (Utils.isEmpty(contentType)) {
    //                log.error("contenttype IS EMPTY--->");
    //                return false;
    //            }
    //            if (VIDEO_CONTENT_TYPES.contains(contentType)) {
    //                return true;
    //            }
    //            return false;
    //        } catch (Exception e) {
    //            log.error("Exception in isVideo(contentType) ->" + e);
    //            return false;
    //        }
    //    }
    //
    //    public static boolean isArchive(String contentType) {
    //
    //        if (log.isDebugEnabled()) {
    //            log.debug("Executing isArchive(contentType) ->");
    //        }
    //
    //        try {
    //            if (Utils.isEmpty(contentType)) {
    //                log.error("contenttype IS EMPTY--->");
    //                return false;
    //            }
    //            if (ARCHIVE_CONTENT_TYPES.contains(contentType)) {
    //                return true;
    //            }
    //            return false;
    //        } catch (Exception e) {
    //            log.error("Exception in isArchive(contentType) ->" + e);
    //            return false;
    //        }
    //    }
    //
    //    public static FileTypeEnum getFileType(String contentType) {
    //
    //        if (log.isDebugEnabled()) {
    //            log.debug("Executing getFileType(contentType) ->");
    //        }
    //
    //        try {
    //            if (Utils.isNotEmpty(contentType)) {
    //                if (isImage(contentType)) {
    //                    return FileTypeEnum.IMAGE;
    //                }
    //                if (isPdf(contentType)) {
    //                    return FileTypeEnum.PDF;
    //                }
    //                if (isSpreadsheet(contentType)) {
    //                    return FileTypeEnum.EXCEL;
    //                }
    //                if (isDocument(contentType)) {
    //                    return FileTypeEnum.DOC;
    //                }
    //                if (isText(contentType)) {
    //                    return FileTypeEnum.TEXT;
    //                }
    //                if (isArchive(contentType)) {
    //                    return FileTypeEnum.ARCHIVE;
    //                }
    //                if (isPresentation(contentType)) {
    //                    return FileTypeEnum.PPT;
    //                }
    //                if (isAudio(contentType)) {
    //                    return FileTypeEnum.AUDIO;
    //                }
    //                if (isVideo(contentType)) {
    //                    return FileTypeEnum.VIDEO;
    //                }
    //            }
    //        } catch (Exception e) {
    //            log.error("Exception in getFileType(contentType) ->" + e);
    //        }
    //        return FileTypeEnum.DEFAULT;
    //    }
    //
    //    // public static FileTypeEnum getFileType(String contentType) {
    //    //
    //    // if (log.isDebugEnabled()) {
    //    // log.debug("Executing getFileType(contentType) ->");
    //    // }
    //    //
    //    // try {
    //    // if (Utils.isNotEmpty(contentType)) {
    //    // if (isImage(contentType)) {
    //    // return FileTypeEnum.IMAGE;
    //    // }
    //    // if (isPdf(contentType)) {
    //    // return FileTypeEnum.PDF;
    //    // }
    //    // if (isSpreadsheet(contentType)) {
    //    // return FileTypeEnum.EXCEL;
    //    // }
    //    // if (isDocument(contentType)) {
    //    // return FileTypeEnum.DOC;
    //    // }
    //    // if (isText(contentType)) {
    //    // return FileTypeEnum.TEXT;
    //    // }
    //    // if (isArchive(contentType)) {
    //    // return FileTypeEnum.ARCHIVE;
    //    // }
    //    // if (isPresentation(contentType)) {
    //    // return FileTypeEnum.PPT;
    //    // }
    //    // if (isAudio(contentType)) {
    //    // return FileTypeEnum.AUDIO;
    //    // }
    //    // if (isVideo(contentType)) {
    //    // return FileTypeEnum.VIDEO;
    //    // }
    //    // }
    //    // } catch (Exception e) {
    //    // log.error("Exception in getFileType(contentType) ->" + e);
    //    // }
    //    // return FileTypeEnum.DEFAULT;
    //    // }
}
