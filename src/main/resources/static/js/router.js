import Home, {HomeEvents} from "./views/Home.js";
import PostIndex from "./views/PostIndex.js";
import About, {AboutEvents} from "./views/About.js";
import Error404 from "./views/Error404.js";
import Loading from "./views/Loading.js";
import Login from "./views/Login.js";
import LoginEvent from "./auth.js";
import Register from "./views/Register.js"
import {RegisterEvent} from "./views/Register.js";
import {PostsEvent} from "./views/PostIndex.js"
import {ProfileEvent} from "./views/User.js";
import Profile from "./views/User.js";
import Logout, {LogoutEvents} from "./views/Logout.js";

/**
 * Returns the route object for a specific route based on the given URI
 * @param URI
 * @returns {*}
 */
export default function router(URI) {

    const routes = {
        '/': {
            returnView: Home,
            state: {},
            uri: '/home',
            title: 'Home',
            viewEvent: HomeEvents
        },
        '/logout': {
            returnView: Logout,
            state: {},
            uri: '/logout',
            title: "Logout",
            viewEvent: LogoutEvents
        },
        '/login': {
            returnView: Login,
            state: {},
            uri: '/login',
            title: "Login",
            viewEvent: LoginEvent
        },
        '/register': {
            returnView: Register,
            state: {},
            uri: '/register',
            title: 'Register',
            viewEvent: RegisterEvent
        },
        '/user': {
            returnView: Profile,
            state: {
                loggedinuser: "/api/user/loggedUser"
                ///the one will have to change to a path parameter for hook up to database
            },
            uri: '/user',
            title: 'Profile',
            viewEvent: ProfileEvent
        },
        '/posts': {
            returnView: PostIndex,
            state: {
                posts: '/api/posts'
            },
            uri: '/posts',
            title: 'All Posts',
            viewEvent: PostsEvent,
        },
        '/about': {
            returnView: About,
            state: {},
            uri: '/about',
            title: 'About',
            viewEvent: AboutEvents
        },
        '/error': {
            returnView: Error404,
            state: {},
            uri: location.pathname,
            title: ' ERROR',
        },
        '/loading': {
            returnView: Loading,
            state: {},
            uri: location.pathname,
            title: 'Loading...',
        }
    };

    return routes[URI];
}

