import {
  GoogleMap,
  Marker,
  useJsApiLoader
} from "@react-google-maps/api";

interface MapProps {
  lat: number;
  lng: number;
}

function Map({ lat, lng }: MapProps) {

  const { isLoaded } =
    useJsApiLoader({
      googleMapsApiKey:
        "AIzaSyBjjwJp8C1DyFSDaJRb8RQWMX93f2241R8"
    });

  if (!isLoaded) {
    return <div>Loading Map...</div>;
  }

  return (
    <GoogleMap
      center={{ lat, lng }}
      zoom={15}
      mapContainerStyle={{
        width: "100%",
        height: "400px"
      }}
    >
      <Marker
        position={{ lat, lng }}
      />
    </GoogleMap>
  );
}

export default Map;