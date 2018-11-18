package com.cxx.util;

/**
 * User: lanxinghua
 * Date: 2018/11/18 19:17
 * Desc: URI统一资源标识符
 */
public class URIUtils {

    public static void main(String[] args) {
        String uri = "https://www.aliyun.com/jiaocheng/83352.html";
        System.out.println(getHost(uri));
        System.out.println(getName(uri));
        System.out.println(getPath(uri));
        System.out.println(getFromPath(uri));
        System.out.println(getPathQuery(uri));
        System.out.println(getQuery(uri));
    }

    /**
     * 获得host
     * @param uri
     * @return
     */
    public static String getHost(String uri){
        if (uri == null) {
            return null;
        }
        // consider of net_path
        int from = uri.indexOf("//");
        int to = uri.indexOf(
                "/",
                from >= 0 ? from+2 : 0
        );
        from = from>=0?from+2:0;
        to = to>0?to:uri.length();

        return uri.substring(from, to);
    }

    /**
     * Get the basename of an URI.   It's possibly an empty string.
     *
     * @param uri a string regarded an URI
     * @return the basename string; an empty string if the path ends with slash
     */
    public static String getName(String uri) {
        if (uri == null || uri.length() == 0) { return uri; }
        String path = URIUtils.getPath(uri);
        int at = path.lastIndexOf("/");
        int to = path.length();
        return (at >= 0) ? path.substring(at + 1, to) : path;
    }


    /**
     * Get the query of an URI.
     *
     * @param uri a string regarded an URI
     * @return the query string; <code>null</code> if empty or undefined
     */
    public static String getQuery(String uri) {
        if (uri == null || uri.length() == 0) { return null; }
        // consider of net_path
        int at = uri.indexOf("//");
        int from = uri.indexOf(
                "/",
                at >= 0 ? (uri.lastIndexOf("/", at - 1) >= 0 ? 0 : at + 2) : 0
        );
        // the authority part of URI ignored
        int to = uri.length();
        // reuse the at and from variables to consider the query
        at = uri.indexOf("?", from);
        if (at >= 0) {
            from = at + 1;
        } else {
            return null;
        }
        // check the fragment
        if (uri.lastIndexOf("#") > from) {
            to = uri.lastIndexOf("#");
        }
        // get the path and query.
        return (from < 0 || from == to) ? null : uri.substring(from, to);
    }


    /**
     * Get the path of an URI.
     *
     * @param uri a string regarded an URI
     * @return the path string
     */
    public static String getPath(String uri) {
        if (uri == null) {
            return null;
        }
        // consider of net_path
        int at = uri.indexOf("//");
        int from = uri.indexOf(
                "/",
                at >= 0 ? (uri.lastIndexOf("/", at - 1) >= 0 ? 0 : at + 2) : 0
        );
        // the authority part of URI ignored
        int to = uri.length();
        // check the query
        if (uri.indexOf('?', from) != -1) {
            to = uri.indexOf('?', from);
        }
        // check the fragment
        if (uri.lastIndexOf("#") > from && uri.lastIndexOf("#") < to) {
            to = uri.lastIndexOf("#");
        }
        // get only the path.
        return (from < 0) ? (at >= 0 ? "/" : uri) : uri.substring(from, to);
    }


    /**
     * Get the path and query of an URI.
     *
     * @param uri a string regarded an URI
     * @return the path and query string
     */
    public static String getPathQuery(String uri) {
        if (uri == null) {
            return null;
        }
        // consider of net_path
        int at = uri.indexOf("//");
        int from = uri.indexOf(
                "/",
                at >= 0 ? (uri.lastIndexOf("/", at - 1) >= 0 ? 0 : at + 2) : 0
        );
        // the authority part of URI ignored
        int to = uri.length();
        // Ignore the '?' mark so to ignore the query.
        // check the fragment
        if (uri.lastIndexOf("#") > from) {
            to = uri.lastIndexOf("#");
        }
        // get the path and query.
        return (from < 0) ? (at >= 0 ? "/" : uri) : uri.substring(from, to);
    }


    /**
     * Get the path of an URI and its rest part.
     *
     * @param uri a string regarded an URI
     * @return the string from the path part
     */
    public static String getFromPath(String uri) {
        if (uri == null) {
            return null;
        }
        // consider of net_path
        int at = uri.indexOf("//");
        int from = uri.indexOf(
                "/",
                at >= 0 ? (uri.lastIndexOf("/", at - 1) >= 0 ? 0 : at + 2) : 0
        );
        // get the path and its rest.
        return (from < 0) ? (at >= 0 ? "/" : uri) : uri.substring(from);
    }
}
