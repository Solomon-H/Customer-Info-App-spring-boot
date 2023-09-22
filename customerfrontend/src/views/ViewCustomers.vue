<template>
  <main>
    <AppNavbar />
    <!-- Table-->
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <h1 class="text-center">Customer Information</h1>

          <!--Add button -->
          <a href="/add" class="btn btn-primary">Add Customer</a>
          <table class="table table-striped">
            <thead>
              <tr>
                <th scope="col">Id</th>
                <th scope="col">Name</th>
                <th scope="col">Email</th>
                <th scope="col">Phone Number</th>
                <th scope="col">Gender</th>
                <th scope="col">Action</th>
              </tr>
            </thead>
            <tbody>
              <tr v-for="customer in customers" :key="customer.id">
                <th scope="row">{{ customer.id }}</th>
                <td>{{ customer.name }}</td>
                <td>{{ customer.email }}</td>
                <td>{{ customer.phoneNumber }}</td>
                <td>{{ customer.gender }}</td>
                <td>
                  <a class="btn btn-primary" :href="`/edit/${customer.id}`"
                    >Edit</a
                  >
                  <button
                    class="btn btn-danger mx-2"
                    @click="deleteCustomer(customer.id)"
                  >
                    Delete
                  </button>
                </td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  </main>
</template>

<script>
import AppNavbar from "../components/AppNavbar.vue";

export default {
  name: "ViewCustomers",
  components: {
    AppNavbar,
  },
  data() {
    return {
      customers: [],
    };
  },

  beforeMount() {
    this.getCustomers();
  },

  methods: {
    getCustomers() {
      fetch("http://localhost:8080/customers")
        .then((res) => res.json())
        .then((data) => {
          this.customers = data;
          console.log(data);
        });
    },
   deleteCustomer(id){
                fetch(`http://localhost:8080/customer/${id}`, {
                    method: 'DELETE'
                })
                .then(data => {
                    console.log(data)
                    this.getCustomers()
                })
    },
  },
};
</script>
