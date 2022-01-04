import {act} from "@testing-library/react";

export const idleForIO = async () => {
    await act(async () => {
        await new Promise((resolve) => setImmediate(resolve));
    });
};