<template>
  <main>
    <AppNavbar />

    <div class="my-5">
      <div class="mx-auto w-25" style="max-width: 100%;">
        <h2 class="text-center mb-3">Update Customer</h2>
        <form @submit.prevent="updateCustomer">
          <!-- name -->
          <div class="row">
            <div class="col-md-12 form-group mb-3">
              <label for="name" class="form-label">Name</label>
              <input
                id="name"
                type="text"
                name="name"
                class="form-control"
                placeholder="Name"
                required
                v-model="customer.name"
              />
            </div>
          </div>

          <!-- Phone Number -->
          <div class="row">
            <div class="col-md-12 form-group mb-3">
              <label for="pNo" class="form-label">Phone Number</label>
              <input
                id="pNo"
                type="text"
                name="pNo"
                class="form-control"
                placeholder="Phone Number"
                required
                v-model="customer.phoneNumber"
              />
            </div>
          </div>

          <!-- Email -->
          <div class="row">
            <div class="col-md-12 form-group mb-3">
              <label for="email" class="form-label">Email</label>
              <input
                id="email"
                type="email"
                name="email"
                class="form-control"
                placeholder="email"
                required
                v-model="customer.email"
              />
            </div>
          </div>

          <div class="row">
            <div class="col-md-12 form-group">
              <input class="btn btn-primary w-100" type="submit" value="Submit" />
            </div>
          </div>
          <div></div>
        </form>
      </div>
    </div>
  </main>
</template>

<script>
import AppNavbar from '../components/AppNavbar.vue';

export default {
  name: 'UpdateCustomer',
  components: {
    AppNavbar
  },

  data() {
    return {
      customer: {
        id: '',
        name: '',
        email: '',
        phoneNumber: '',
        gender: ''
      }
    };
  },

  beforeMount() {
    this.getCustomer();
  },

  methods: {
    getCustomer() {
      fetch(`http://localhost:8080/customer/${this.$route.params.id}`)
        .then(res => res.json())
        .then(data => {
          this.customer = data;
          console.log(this.customer);
        });
    },
    updateCustomer() {
      fetch(`http://localhost:8080/customer`, {
        method: 'PUT',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(this.customer)
      })
        .then(data => {
          console.log(data);
          this.$router.push('/');
        });
    }
  }
};
</script>
