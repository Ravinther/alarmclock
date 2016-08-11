package com.millennialmedia.android;

import android.content.Context;
import android.net.Uri;
import android.os.StatFs;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.google.android.gms.plus.PlusShare;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import org.json.JSONArray;

class BridgeMMFileManager extends MMJSObject {
    private File root;

    BridgeMMFileManager() {
    }

    private boolean hasCreativeDirectory() {
        Context context = (Context) this.contextRef.get();
        if (context != null) {
            File cacheDirectory = AdCache.getCacheDirectory(context);
            this.root = cacheDirectory;
            if (cacheDirectory != null) {
                return true;
            }
        }
        return false;
    }

    public MMJSResponse getFreeDiskSpace(HashMap arguments) {
        if (!hasCreativeDirectory()) {
            return null;
        }
        MMJSResponse response = new MMJSResponse();
        response.result = 1;
        StatFs stat = new StatFs(this.root.getAbsolutePath());
        response.response = new Long(((long) stat.getAvailableBlocks()) * ((long) stat.getBlockSize()));
        return response;
    }

    public MMJSResponse getDirectoryContents(HashMap arguments) {
        if (!hasCreativeDirectory()) {
            return null;
        }
        File dir;
        if (arguments.containsKey("path")) {
            dir = new File(this.root, (String) arguments.get("path"));
        } else {
            dir = this.root;
        }
        JSONArray jsonArray = new JSONArray();
        for (String file : dir.list()) {
            jsonArray.put(file);
        }
        MMJSResponse response = new MMJSResponse();
        response.result = 1;
        response.response = jsonArray;
        return response;
    }

    public MMJSResponse getFileContents(HashMap arguments) {
        MMJSResponse response;
        Throwable th;
        if (hasCreativeDirectory()) {
            FileInputStream fileStream = null;
            if (arguments.containsKey("path")) {
                byte[] contents;
                try {
                    File file = new File(this.root, (String) arguments.get("path"));
                    FileInputStream fileStream2 = new FileInputStream(file);
                    try {
                        contents = new byte[((int) file.length())];
                        fileStream2.read(contents);
                        if (fileStream2 != null) {
                            try {
                                fileStream2.close();
                            } catch (Exception e) {
                                fileStream = fileStream2;
                            }
                        }
                        fileStream = fileStream2;
                    } catch (Exception e2) {
                        fileStream = fileStream2;
                        contents = null;
                        if (fileStream != null) {
                            try {
                                fileStream.close();
                            } catch (Exception e3) {
                            }
                        }
                        if (contents != null) {
                            response = new MMJSResponse();
                            response.result = 1;
                            response.dataResponse = contents;
                            return response;
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        fileStream = fileStream2;
                        if (fileStream != null) {
                            try {
                                fileStream.close();
                            } catch (Exception e4) {
                            }
                        }
                        throw th;
                    }
                } catch (Exception e5) {
                    contents = null;
                    if (fileStream != null) {
                        fileStream.close();
                    }
                    if (contents != null) {
                        response = new MMJSResponse();
                        response.result = 1;
                        response.dataResponse = contents;
                        return response;
                    }
                    return null;
                } catch (Throwable th3) {
                    th = th3;
                    if (fileStream != null) {
                        fileStream.close();
                    }
                    throw th;
                }
                if (contents != null) {
                    response = new MMJSResponse();
                    response.result = 1;
                    response.dataResponse = contents;
                    return response;
                }
            }
        }
        return null;
    }

    public MMJSResponse writeData(HashMap arguments) {
        Throwable th;
        if (hasCreativeDirectory()) {
            FileOutputStream fileStream = null;
            boolean success = false;
            if (arguments.containsKey("path") && arguments.containsKey("data")) {
                try {
                    File file = new File(this.root, (String) arguments.get("path"));
                    byte[] contents = Base64.decode((String) arguments.get("data"));
                    FileOutputStream fileStream2 = new FileOutputStream(file);
                    try {
                        fileStream2.write(contents);
                        success = true;
                        if (fileStream2 != null) {
                            try {
                                fileStream2.close();
                            } catch (Exception e) {
                                fileStream = fileStream2;
                            }
                        }
                        fileStream = fileStream2;
                    } catch (Exception e2) {
                        fileStream = fileStream2;
                        if (fileStream != null) {
                            try {
                                fileStream.close();
                            } catch (Exception e3) {
                            }
                        }
                        if (success) {
                            return MMJSResponse.responseWithSuccess("File written successfully");
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        fileStream = fileStream2;
                        if (fileStream != null) {
                            try {
                                fileStream.close();
                            } catch (Exception e4) {
                            }
                        }
                        throw th;
                    }
                } catch (Exception e5) {
                    if (fileStream != null) {
                        fileStream.close();
                    }
                    if (success) {
                        return MMJSResponse.responseWithSuccess("File written successfully");
                    }
                    return null;
                } catch (Throwable th3) {
                    th = th3;
                    if (fileStream != null) {
                        fileStream.close();
                    }
                    throw th;
                }
                if (success) {
                    return MMJSResponse.responseWithSuccess("File written successfully");
                }
            }
        }
        return null;
    }

    public MMJSResponse downloadFile(HashMap arguments) {
        Context context = (Context) this.contextRef.get();
        String url = (String) arguments.get(PlusShare.KEY_CALL_TO_ACTION_URL);
        if (!(TextUtils.isEmpty(url) || context == null)) {
            String name;
            if (arguments.containsKey("path")) {
                name = (String) arguments.get("path");
            } else {
                name = Uri.parse((String) arguments.get(PlusShare.KEY_CALL_TO_ACTION_URL)).getLastPathSegment();
            }
            if (AdCache.downloadComponentToCache(url, name, context)) {
                return MMJSResponse.responseWithSuccess(name);
            }
        }
        return null;
    }

    public MMJSResponse moveFile(HashMap arguments) {
        if (hasCreativeDirectory()) {
            try {
                String fromPath = (String) arguments.get("fromPath");
                String toPath = (String) arguments.get("toPath");
                if (!(fromPath == null || toPath == null || !new File(this.root, fromPath).renameTo(new File(this.root, toPath)))) {
                    return MMJSResponse.responseWithSuccess("File moved successfully");
                }
            } catch (Exception e) {
            }
        }
        return null;
    }

    public MMJSResponse removeAtPath(HashMap arguments) {
        if (hasCreativeDirectory()) {
            try {
                String path = (String) arguments.get("path");
                if (path != null && new File(this.root, path).delete()) {
                    return MMJSResponse.responseWithSuccess("File removed successfully");
                }
            } catch (Exception e) {
            }
        }
        return null;
    }

    public MMJSResponse getMimeType(HashMap arguments) {
        if (hasCreativeDirectory()) {
            String[] components = ((String) arguments.get("path")).split("\\.");
            String mime = MimeTypeMap.getSingleton().getMimeTypeFromExtension(components[components.length - 1]);
            if (mime != null) {
                MMJSResponse response = new MMJSResponse();
                response.result = 1;
                response.response = mime;
                return response;
            }
        }
        return null;
    }

    public MMJSResponse cleanupCache(HashMap arguments) {
        boolean clear = false;
        long timeout = 259200000;
        if (hasCreativeDirectory()) {
            if (arguments.containsKey("clear")) {
                clear = Boolean.parseBoolean((String) arguments.get("clear"));
            }
            if (clear) {
                timeout = 0;
            } else {
                Context context = (Context) this.contextRef.get();
                if (context != null) {
                    timeout = HandShake.sharedHandShake(context).creativeCacheTimeout;
                }
            }
            try {
                AdCache.cleanupDirectory(this.root, timeout);
            } catch (SecurityException e) {
            }
        }
        return null;
    }
}
