import {
  GoogleMap,
  Marker,
  useJsApiLoader,
} from "@react-google-maps/api";

interface MapProps {
  lat: number;
  lng: number;
}

const containerStyle = {
  width: "100%",
  height: "400px",
  borderRadius: "12px",
};

function Map({ lat, lng }: MapProps) {
  const { isLoaded, loadError } = useJsApiLoader({
    googleMapsApiKey: import.meta.env.VITE_GOOGLE_MAPS_KEY,
  });

  if (loadError) {
    return (
      <div
        style={{
          color: "red",
          marginTop: "20px",
        }}
      >
        Failed to load Google Maps.
      </div>
    );
  }

  if (!isLoaded) {
    return (
      <div
        style={{
          marginTop: "20px",
        }}
      >
        Loading Map...
      </div>
    );
  }

  return (
    <GoogleMap
      mapContainerStyle={containerStyle}
      center={{ lat, lng }}
      zoom={16}
    >
      <Marker position={{ lat, lng }} />
    </GoogleMap>
  );
}

export default Map;
