<template id="animal-detail">
    <div>
        <h1>{{animal.scientificName}}</h1>
        <p>Normal name: {{animal.name}}</p>
        <p>Animal type: {{animal.type}}</p>
        <p v-if="animal.type === 'amphibian'"> Amphibian group: {{animal.group}} </p>
        <p v-if="animal.type === 'invertebrate'"> Has {{animal.legs}} legs </p>
        <p v-if="animal.type === 'bird'"> It <span v-if="animal.canFly"> can fly</span> <span v-else> can't fly</span> </p>
    </div>
</template>
<script>
    Vue.component("animal-detail", {
        template: "#animal-detail",
        data: () => ({
            animal: null,
        }),
        created() {
            const observationName = this.$javalin.pathParams["observation-name"];
            fetch(`/api/observations/${observationName}/animal`)
                .then(res => res.json())
                .then(res => this.animal = res)
                .catch(() => alert("error while fetching animal"))
        }
    })
</script>
<style>

</style>