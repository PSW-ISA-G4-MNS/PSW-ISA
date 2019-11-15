import routes from './routes';


Vue.use(VueRouter)

const router = new VueRouter({routes});
router.beforeEach((to, from, next) => {
  store.dispatch('fetchAccessToken');
  if (to.fullPath !== '/login') {
    if (localStorage.getItem("user")) {
      next('/login');
    }
  }
  if (to.fullPath === '/login') {
    if (localStorage.getItem("user")) {
      next('/');
    }
  }
  next();
});

export default router;
