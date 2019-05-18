package cn.com.ofashion.nativerouter;

import java.net.URI;

public interface IRouteRedirection {
    boolean needRedirectURI(URI uri);
    URI redirectURL(URI uri);
}
