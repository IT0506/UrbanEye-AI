import { useState } from "react";
import Map from "../components/Map";
import Navbar from "../components/Navbar";
import UploadCard from "../components/UploadCard";
import ResultCard from "../components/ResultCard";

interface AnalysisResponse {
  issueType: string;
  severity: string;
  complaint: string;
}

function Home() {
  const [file, setFile] = useState<File | null>(null);

  const [latitude, setLatitude] = useState<number | null>(null);
  const [longitude, setLongitude] = useState<number | null>(null);

  const [result, setResult] =
    useState<AnalysisResponse | null>(null);

  const handleAnalyze = async () => {
    if (!file) {
      alert("Please select an image first");
      return;
    }

    navigator.geolocation.getCurrentPosition(
      (position) => {
        setLatitude(position.coords.latitude);
        setLongitude(position.coords.longitude);
      },
      (error) => {
        console.error(error);
      }
    );

    const formData = new FormData();
    formData.append("file", file);

    try {
      const response = await fetch(
        "http://localhost:8080/api/issues/upload-analyze",
        {
          method: "POST",
          body: formData,
        }
      );

      if (!response.ok) {
        throw new Error("Server Error");
      }

      const data: AnalysisResponse =
        await response.json();

      setResult(data);
    } catch (error) {
      console.error(error);
      alert("Analysis failed");
    }
  };

  return (
    <>
      <Navbar />

      <div
        style={{
          maxWidth: "1200px",
          margin: "0 auto",
          padding: "30px",
        }}
      >
        <h1>UrbanEye AI</h1>

        <UploadCard
          onFileSelect={setFile}
          onAnalyze={handleAnalyze}
        />

        {latitude !== null &&
          longitude !== null && (
            <div style={{ marginTop: "20px" }}>
              <h3>Current Location</h3>

              <Map
                lat={latitude}
                lng={longitude}
              />

              <p>
                Latitude: {latitude}
              </p>

              <p>
                Longitude: {longitude}
              </p>
            </div>
          )}

        {result && (
          <ResultCard
            issueType={result.issueType}
            severity={result.severity}
            complaint={result.complaint}
          />
        )}
      </div>
    </>
  );
}

export default Home;
