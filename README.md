# add-files-buildpack
CF Buildpack that adds files to application

## Examples

### Generating app content

In the app manifest add to the environment :
```yaml
      CONTENT_TO_ADD: |
        ---
        files:
          - path: "index.html"
            content: "<h1>Hello world!</h1>"
          - path: "hidden.html"
            content: "Peekaboo!"
``` 

Push the application like this:
```bash
cd examples/content
cf push -b https://github.com/hsiliev/add-files-buildpack.git -b staticfile_buildpack
```

The `add-files-buildpack` will create 2 files:
- `index.html`
- `hidden.html`

The `staticfile_buildpack` will then package the files.


### Setting up certificates

Check this [manifest](./examples/certificate/manifest.yaml) for example on how to add CA for Java app in IBM Cloud.

Push the dummy app that triggers Java Buildpack:
```bash
cd examples/certificate
./build
cf push 
```


## Details
Check [How buildpacks work in CF](https://docs.cloudfoundry.org/buildpacks/understand-buildpacks.html) for details

To explore the available binaries and files on the filesystem use:
```bash
docker run -it cloudfoundry/cflinuxfs3 bash
```