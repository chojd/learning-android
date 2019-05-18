package cn.com.ofashion.nativerouter.redirector;

import java.net.URI;

import cn.com.ofashion.nativerouter.IRouteRedirection;

abstract class AbsRouteRedirector implements IRouteRedirection {
    public boolean needRedirectURI(URI uri) {

        if (uri == null) return false;

        if (standardScheme() == null) return false;

        if (uri.getScheme().equals(standardScheme())) return true;

        return false;
    }

    @Override
    public URI redirectURL(URI uri) {
        return null;
    }

    String standardScheme() {
        return null;
    }
}
