import { createRouter, createWebHistory } from 'vue-router'
import ViewCustomers from '../views/ViewCustomers.vue'

const router = createRouter({
  history: createWebHistory(process.env.VUE_APP_BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: ViewCustomers
    },
    {
      path: '/add',
      name: 'add',
      component: () => import('../views/AddCustomer.vue')
    },
    {
      path: '/edit/:id',
      name: 'edit',
      component: () => import('../views/UpdateCustomer.vue')
    }
  ]
})

export default router
