<template id="planet-detail">
    <div>
        <h1>Planet name: {{planet.name}}</h1>
    </div>
</template>
<script>
    Vue.component("planet-detail", {
        template: "#planet-detail",
        data: () => ({
            planet: null,
        }),
        created() {
            const observationName = this.$javalin.pathParams["observation-name"];
            fetch(`/api/observations/${observationName}/planet`)
                .then(res => res.json())
                .then(res => this.planet = res)
                .catch(() => alert("error while fetching animal"))
        }
    })
</script>
<style>

</style>