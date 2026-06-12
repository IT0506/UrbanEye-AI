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

const API_URL =
  import.meta.env.VITE_API_URL ||
  "http://localhost:8080";

function Home() {
  const [file, setFile] = useState<File | null>(null);

  const [latitude, setLatitude] = useState<number | null>(null);
  const [longitude, setLongitude] = useState<number | null>(null);

  const [result, setResult] =
    useState<AnalysisResponse | null>(null);

  const [loading, setLoading] = useState(false);

  const handleAnalyze = async () => {
    if (!file) {
      alert("Please select an image first.");
      return;
    }

    setLoading(true);

    // Get user's location (optional)
    if (navigator.geolocation) {
      navigator.geolocation.getCurrentPosition(
        (position) => {
          setLatitude(position.coords.latitude);
          setLongitude(position.coords.longitude);
        },
        (error) => {
          console.log("Location unavailable:", error.message);
        }
      );
    }

    const formData = new FormData();
    formData.append("file", file);

    try {
      const response = await fetch(
        `${API_URL}/api/issues/upload-analyze`,
        {
          method: "POST",
          body: formData,
        }
      );

      if (!response.ok) {
        const text = await response.text();
        console.error(text);
        throw new Error("Backend request failed");
      }

      const data: AnalysisResponse =
        await response.json();

      setResult(data);
    } catch (error) {
      console.error(error);
      alert("Unable to analyze image.");
    } finally {
      setLoading(false);
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

        {loading && (
          <p style={{ marginTop: 20 }}>
            Analyzing image...
          </p>
        )}

        {latitude !== null && longitude !== null && (
          <div style={{ marginTop: "30px" }}>
            <h2>Current Location</h2>

            <Map
              lat={latitude}
              lng={longitude}
            />

            <p>
              <strong>Latitude:</strong>{" "}
              {latitude.toFixed(6)}
            </p>

            <p>
              <strong>Longitude:</strong>{" "}
              {longitude.toFixed(6)}
            </p>
          </div>
        )}

        {result && (
          <div style={{ marginTop: "30px" }}>
            <ResultCard
              issueType={result.issueType}
              severity={result.severity}
              complaint={result.complaint}
            />
          </div>
        )}
      </div>
    </>
  );
}

export default Home;
